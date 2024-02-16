<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Registro Historial</title>
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
        textarea {
            min-height:   150px;
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
    <h2 class="text-center my-4">Agregar Registro al Historial del Paciente</h2>
    <form action="./agregar_registro_historial" method="post">
        <div class="form-group">
            <label for="diagnostico">Diagnóstico:</label>
            <textarea id="diagnostico" name="diagnostico" class="form-control" rows="4"></textarea>
        </div>
        <div class="form-group">
            <label for="tratamiento">Tratamiento:</label>
            <textarea id="tratamiento" name="tratamiento" class="form-control" rows="4"></textarea>
        </div>
        <div class="form-group">
            <input type="hidden" name="idHistorial" value="${historial.id_historial}">
            <input type="hidden" name="idPaciente" value="${idPaciente}">
            <button type="submit" class="btn btn-primary btn-block">Añadir Registro</button>
        </div>
    </form>
</div>
</body>
</html>
