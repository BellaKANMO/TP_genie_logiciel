<?php
require_once __DIR__ . '/api_client.php';

$id = (int)($_GET['id'] ?? 0);
if ($id <= 0) { die("ID invalide"); }

$res = api_delete($id);

if ($res['code'] === 204) {
    header('Location: index.php');
    exit;
}

echo "<h1>Erreur suppression</h1>";
echo "<pre>" . htmlspecialchars($res['raw'] ?? 'Erreur inconnue') . "</pre>";
echo '<p><a href="index.php">Retour</a></p>';
