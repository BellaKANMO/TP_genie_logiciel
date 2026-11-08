<?php
require_once __DIR__ . '/api_client.php';

$res = api_get_all();
$etudiants = ($res['code'] === 200 && is_array($res['body'])) ? $res['body'] : [];
?>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>TP Etudiants</title>
</head>
<body>
    <h1>Liste des étudiants</h1>
    <p><a href="create.php">+ Ajouter un étudiant</a></p>

    <?php if ($res['code'] !== 200): ?>
        <p style="color:red;">Erreur API (code <?= htmlspecialchars((string)$res['code']) ?>)</p>
        <pre><?= htmlspecialchars($res['raw'] ?? '') ?></pre>
    <?php endif; ?>

    <table border="1" cellpadding="6" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Matricule</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Niveau</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($etudiants as $e): ?>
                <tr>
                    <td><?= htmlspecialchars((string)$e['id']) ?></td>
                    <td><?= htmlspecialchars($e['matricule'] ?? '') ?></td>
                    <td><?= htmlspecialchars($e['nom'] ?? '') ?></td>
                    <td><?= htmlspecialchars($e['prenom'] ?? '') ?></td>
                    <td><?= htmlspecialchars($e['email'] ?? '') ?></td>
                    <td><?= htmlspecialchars($e['niveau'] ?? '') ?></td>
                    <td>
                        <a href="edit.php?id=<?= (int)$e['id'] ?>">Modifier</a>
                        |
                        <a href="delete.php?id=<?= (int)$e['id'] ?>" onclick="return confirm('Supprimer ?');">Supprimer</a>
                    </td>
                </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</body>
</html>
