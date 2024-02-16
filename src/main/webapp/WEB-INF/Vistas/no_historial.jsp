<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>No hay Historial Registrado</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Paleta de colores personalizada */
        :root {
            --primary-color: #007bff;
            --primary-color-hover: #0056b3;
            --background-color: #f4f4f4;
            --text-color: #333;
        }

        body {
            background-color: var(--background-color);
            color: var(--text-color);
        }
        .container {
            max-width:   800px;
            margin:   0 auto;
            padding:   20px;
            background-color: #fff;
            box-shadow:   0   0   10px rgba(0,   0,   0,   0.1);
        }
        h2 {
            text-align: center;
            padding:   20px   0;
        }
        .btn-primary {
            background-color: var(--primary-color);
            border-color: var(--primary-color);
        }
        .btn-primary:hover {
            background-color: var(--primary-color-hover);
            border-color: var(--primary-color-hover);
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center my-4">No hay Historial Registrado para este Paciente</h2>
    <p class="text-center">Este paciente no tiene un historial registrado. ¿Desea crear un historial para este paciente?</p>
    <div class="text-center">
        <a href="./crear_historial?id=${idPaciente}" class="btn btn-primary">Crear Historial</a>
    </div>
</div>
</body>
</html>
