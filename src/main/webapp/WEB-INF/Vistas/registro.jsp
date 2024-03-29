<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VitaHealth - Online | Registro</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #222;
            display: flex;
            justify-content: center;
            align-items: center;
            place-content: center;
            height: 100vh;
        }

        .registro-container {
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .registro-container h2 {
            margin-bottom: 20px;
            text-align: center;
            color: #28a745; /* Color verde para el título */
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            font-weight: bold;
        }

        .form-group input[type="text"],
        .form-group input[type="password"],
        .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #28a745; /* Color verde para el botón */
            border: none;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-group button:hover {
            background-color: #218838; /* Color verde oscuro al pasar el cursor */
        }

        /* Estilo para el enlace de inicio de sesión */
        .login-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #28a745; /* Color verde para el enlace */
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .login-link:hover {
            color: #218838; /* Color verde oscuro al pasar el cursor */
        }
    </style>
</head>
<body>
<div class="registro-container">
    <h2>Registro de Usuario</h2>
    <form action="./register" method="post">
        <div class="form-group">
            <label for="usuario">Usuario:</label>
            <input type="text" id="usuario" name="usuario" required>
        </div>
        <div class="form-group">
            <label for="contrasena">Contraseña:</label>
            <input type="password" id="contrasena" name="contrasena" required>
        </div>
        <div class="form-group">
            <label for="rol">Rol:</label>
            <select id="rol" name="rol" required>
                <option value="Paciente">Paciente</option>
                <option value="Medico">Médico</option>
            </select>
        </div>
        <div class="form-group">
            <button type="submit">Registrar</button>
        </div>
    </form>
    <p>¿Ya tienes una cuenta? <a href="./login" class="login-link">Inicia sesión aqui</a></p>
</div>
</body>
</html>
