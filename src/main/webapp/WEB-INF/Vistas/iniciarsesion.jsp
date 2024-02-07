<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07/02/2024
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>VitaHealth - Online | Iniciar Sesion</title>
  <style>
    body {
      place-content: center;
      font-family: Arial, sans-serif;
      background-color: #222;
    }

    .container {
      max-width: 400px;
      margin: 100px auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      text-align: center;
      margin-bottom: 30px;
      color: #333;
    }

    input[type="text"], input[type="password"] {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      width: 100%;
      background-color: #4caf50;
      color: white;
      padding: 10px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }

    .error-message {
      color: #ff0000;
      margin-top: 10px;
      text-align: center;
    }

    .register-link {
      display: inline-block;
      margin-top:  20px;
      padding:  10px  20px;
      background-color: #4caf50;
      color: white;
      text-decoration: none;
      border-radius:  4px;
      transition: background-color  0.3s ease;
    }

    .register-link:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<c:if test="${not empty error}">
  <div class="error-message">${error}</div>
</c:if>
<div class="container">
  <h2>Iniciar Sesion</h2>
  <form action="./login" method="post">
    <input type="text" name="username" placeholder="Nombre de usuario" required>
    <input type="password" name="password" placeholder="Contrasena" required>
    <input type="submit" value="Iniciar Sesion">
  </form>
  <div style="text-align: center;">
    <p>Aun no estas registrado?</p>
    <a href="./register" class="register-link">Registrarse</a>
  </div>
</div>

</body>
</html>

