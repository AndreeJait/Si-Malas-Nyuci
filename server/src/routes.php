<?php

use Slim\App;
use Slim\Http\Request;
use Slim\Http\Response;

return function (App $app) {
    $container = $app->getContainer();

    // $app->get('/[{name}]', function (Request $request, Response $response, array $args) use ($container) {
    //     // Sample log message
    //     $container->get('logger')->info("Slim-Skeleton '/' route");

    //     // Render index view
    //     return $container->get('renderer')->render($response, 'index.phtml', $args);
    // });

    $cekApiKey = function ($request, $response, $next) {
        $key = $request->getQueryParam('key');
        if (!isset($key)) {
            return $response->withJson(["status" => "API Key required"], 401);
        }

        $sql = "SELECT * FROM api_users WHERE api_key=:api_key";
        $stmt = $this->db->prepare($sql);
        $stmt->execute([":api_key" => $key]);

        if ($stmt->rowCount() > 0) {
            $result = $stmt->fetch();
            if ($key == $result["api_key"]) {

                // update hit
                $sql = "UPDATE api_users SET hit=hit+1 WHERE api_key=:api_key";
                $stmt = $this->db->prepare($sql);
                $stmt->execute([":api_key" => $key]);

                return $response = $next($request, $response);
            }
        }
        return $response->withJson(["status" => "Unauthorized"], 401);
    };

    $app->post('/api/login', function (Request $request, Response $response) {

        if ($request->getParsedBody() !== null) {
            $users = $request->getParsedBody();
            $sql = "SELECT * FROM users where email=:email";
            $stmt = $this->db->prepare($sql);
            $stmt->execute([':email' => $users['email']]);
            if ($stmt->rowCount() > 0) {
                $result = $stmt->fetch();
                if (password_verify($users['password'], $result['password'])) {
                    return $response->withJson(['status' => 'success', 'message' => 'Succes To Login', 'user' => $result], 200);
                } else {
                    return $response->withJson(['status' => 'failed', 'message' => 'Auth Invalid', 'user' => null], 401);
                }
            } else {
                return $response->withJson(['status' => 'failed', 'message' => 'Email Not Found','user' => null], 404);
            }
        }
        return $response->withJson(['status' => 'failed', 'message' => 'Email and Password Needed', 'user' =>null], 500);
    });
    $app->post('/api/register', function (Request $request, Response $response) {

        if ($request->getParsedBody() !== null) {
            $users = $request->getParsedBody();
            $sql = "SELECT * FROM users where email=:email";
            $stmt = $this->db->prepare($sql);
            $stmt->execute([':email' => $users['email']]);
            if ($stmt->rowCount() <= 0) {
                $full_name = $users['full_name'];
                $email = $users['email'];
                $password = $users['password'];
                $phone_number = $users['phone_number'];
                $role = $users['role'] === 1 ? 'Owner' : 'Employees';

                $sql = "INSERT INTO users (full_name, email, password, phone_number, role) VALUES (:full_name, :email, :password, :phone_number, :role)";

                $needed = [
                    ':full_name' => $full_name,
                    ':email' => $email,
                    ':password' => password_hash($password, PASSWORD_DEFAULT),
                    ':phone_number' => $phone_number,
                    ':role' => $role
                ];

                $stmt = $this->db->prepare($sql);
                if ($stmt->execute($needed)) {
                    $sql = "SELECT * FROM users where email=:email";
                    $stmt = $this->db->prepare($sql);
                    $stmt->execute([':email' => $users['email']]);
                    $result = $stmt->fetch();
                    return $response->withJson(['status' => 'success', 'message' => 'Succes To Register', 'user' => $result], 200);
                } else {
                    return $response->withJson(['status' => 'failed', 'message' => 'Failed to insert data', 'user' => null], 400);
                }
            }else{
                return $response->withJson(['status' => 'failed', 'message' => 'Email Exist', 'user' => null], 400);
            }
        }
        return $response->withJson(['status' => 'failed', 'message' => 'Internal Server Error', 'user' =>null], 500);
    });
    $app->get("/info/laundry/{id}", function (Request $request, Response $response) {
        return $response->withJson(['password_has' => password_hash('andree110102', PASSWORD_DEFAULT)], 200);
    })->add($cekApiKey);
};
