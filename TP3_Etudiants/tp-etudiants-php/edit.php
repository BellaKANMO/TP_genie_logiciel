<?php
require_once __DIR__ . '/api_client.php';

$id = (int)($_GET['id'] ?? 0);
if ($id <= 0) { die("ID invalide"); }

$error = null;
$etudiant = null;

// Charger l'étudiant
$read = api_get_one($id);
if ($read['code'] === 200) {
    $etudiant = $read['body'];
} else {
    die("Etudiant introuvable (code " . htmlspecialchars((string)$read['code']) . ")");
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $payload = [
        'matricule' => trim($_POST['matricule'] ?? ''),
        'nom' => trim($_POST['nom'] ?? ''),
        'prenom' => trim($_POST['prenom'] ?? ''),
        'email' => trim($_POST['email'] ?? ''),
        'dateNaissance' => ($_POST['dateNaissance'] ?? '') ?: null,
        'niveau' => trim($_POST['niveau'] ?? ''),
    ];

    $res = api_update($id, $payload);

    if ($res['code'] === 200) {
        header('Location: index.php');
        exit;
    }
    $error = $res['raw'] ?? 'Erreur inconnue';
}
?>
<!doctype html>
<html lang="fr">
<head><meta charset="utf-8"><title>Modifier étudiant</title></head>
<body>
    <h1>Modifier étudiant #<?= (int)$id ?></h1>
    <p><a href="index.php">← Retour</a></p>

    <?php if ($error): ?>
        <p style="color:red;">Erreur :</p>
        <pre><?= htmlspecialchars($error) ?></pre>
    <?php endif; ?>

    <form method="post">
        <label>Matricule: <input name="matricule" required value="<?= htmlspecialchars($etudiant['matricule'] ?? '') ?>"></label><br><br>
        <label>Nom: <input name="nom" required value="<?= htmlspecialchars($etudiant['nom'] ?? '') ?>"></label><br><br>
        <label>Prénom: <input name="prenom" required value="<?= htmlspecialchars($etudiant['prenom'] ?? '') ?>"></label><br><br>
        <label>Email: <input name="email" type="email" value="<?= htmlspecialchars($etudiant['email'] ?? '') ?>"></label><br><br>
        <label>Date naissance: <input name="dateNaissance" type="date" value="<?= htmlspecialchars($etudiant['dateNaissance'] ?? '') ?>"></label><br><br>
        <label>Niveau: <input name="niveau" value="<?= htmlspecialchars($etudiant['niveau'] ?? '') ?>"></label><br><br>
        <button type="submit">Mettre à jour</button>
    </form>
</body>
</html>
