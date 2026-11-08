<?php
require_once __DIR__ . '/config.php';

function api_request(string $method, string $url, ?array $data = null): array {
    $ch = curl_init();

    $headers = [
        'Accept: application/json',
        'Content-Type: application/json'
    ];

    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $method);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);

    if ($data !== null) {
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
    }

    $responseBody = curl_exec($ch);
    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);

    if ($responseBody === false) {
        $err = curl_error($ch);
        curl_close($ch);
        return ['code' => 0, 'body' => null, 'error' => $err];
    }

    curl_close($ch);

    $decoded = json_decode($responseBody, true);
    return ['code' => $httpCode, 'body' => $decoded, 'raw' => $responseBody];
}


function api_get_all(): array {
    return api_request('GET', API_BASE);
}

function api_get_one(int $id): array {
    return api_request('GET', API_BASE . '/' . $id);
}

function api_create(array $payload): array {
    return api_request('POST', API_BASE, $payload);
}

function api_update(int $id, array $payload): array {
    return api_request('PUT', API_BASE . '/' . $id, $payload);
}

function api_delete(int $id): array {
    return api_request('DELETE', API_BASE . '/' . $id);
}
