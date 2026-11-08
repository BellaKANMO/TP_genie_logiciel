<?php
require_once __DIR__ . '/api_client.php';

$error = null;

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $payload = [
        'matricule' => trim($_POST['matricule'] ?? ''),
        'nom' => trim($_POST['nom'] ?? ''),
        'prenom' => trim($_POST['prenom'] ?? ''),
        'email' => trim($_POST['email'] ?? ''),
        'dateNaissance' => ($_POST['dateNaissance'] ?? '') ?: null,
        'niveau' => trim($_POST['niveau'] ?? ''),
    ];

    $res = api_create($payload);

    if ($res['code'] === 201) {
        header('Location: index.php');
        exit;
    }
    $error = $res['raw'] ?? 'Erreur inconnue';
}
?>
<!doctype html>
<html lang="fr">
<head><meta charset="utf-8"><title>Créer étudiant</title></head>
<body>
    <h1>Créer un étudiant</h1>
    <p><a href="index.php">← Retour</a></p>

    <?php if ($error): ?>
        <p style="color:red;">Erreur :</p>
        <pre><?= htmlspecialchars($error) ?></pre>
    <?php endif; ?>

    <form method="post">
        <label>Matricule: <input name="matricule" required></label><br><br>
        <label>Nom: <input name="nom" required></label><br><br>
        <label>Prénom: <input name="prenom" required></label><br><br>
        <label>Email: <input name="email" type="email"></label><br><br>
        <label>Date naissance: <input name="dateNaissance" type="date"></label><br><br>
        <label>Niveau: <input name="niveau" placeholder="L1, L2, L3, M1..."></label><br><br>
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
