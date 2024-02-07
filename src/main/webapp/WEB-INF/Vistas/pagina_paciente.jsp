<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel de Control del Cliente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        /* Estilos generales para el cuerpo del documento */
        body {
            font-family: 'Roboto', sans-serif;
            transition: background-color  0.5s ease, color  0.5s ease;
        }

        /* Estilos para el modo oscuro */
        body.theme-dark {
            background-color: #343a40;
            color: #fff;
        }

        /* Estilos para el modo claro */
        body.theme-light {
            background-color: #f8f9fa;
            color: #212529;
        }

        /* Estilos para el navbar */
        .navbar {
            background-color: #007bff;
        }

        .navbar-brand {
            color: white;
        }

        /* Estilos para las tarjetas */
        .card {
            border-radius:  10px;
            box-shadow:  0  4px  8px  0 rgba(0,0,0,0.2);
            transition:  0.3s;
            margin-bottom: 2rem;
        }

        .theme-dark .card {
            background-color: #495057;
            color: #fff;
        }

        .card:hover {
            box-shadow:  0  8px  16px  0 rgba(0,0,0,0.2);
        }

        /* Estilos para los títulos de las secciones */
        .section-title {
            font-size:  24px;
            margin:  0;
            padding:  20px;
            background-color: #007bff;
            color: #fff;
            text-align: center;
        }

        /* Estilos para los botones */
        .button {
            display: block;
            width:  100%;
            padding:  10px;
            background-color: #007bff;
            text-decoration: none;
            color: #fff;
            border: none;
            border-radius:  5px;
            text-align: center;
            transition: background-color  0.3s ease;
            margin-bottom:  10px;
        }

        .button:hover {
            background-color: #0056b3;
            color: #f0f0f0;
            text-decoration: none;
        }
        .section-content {
            padding:  20px; /* Agrega un relleno interno para dar espacio alrededor del texto */
        }
        /* Estilos para el contenedor principal */
        .main-content {
            margin-top:  2rem;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">Panel de Control del Cliente</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link text-white" href="./logout">Cerrar Sesión</a>
            </li>
            <li class="nav-item">
                <button id="themeButton" class="btn btn-light" onclick="toggleTheme()">Modo Oscuro</button>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid main-content">
    <div class="row">
        <div class="col-md-6 col-lg-4">
            <div class="card">
                <div class="section-title"><i class="bi bi-person-circle"></i> Registro y Perfil de Usuario</div>
                <div class="section-content">
                    <p>Regístrate, crea tu perfil y accede a tu historial clínico.</p>
                    <p>Actualiza tu información personal y clínica fácilmente.</p>
                    <a href="/registro_perfil" class="button">Ir a Registro y Perfil</a>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card">
                <div class="section-title"><i class="bi bi-telephone-fill"></i> Consulta en Línea</div>
                <div class="section-content">
                    <p>Programa consultas en línea con profesionales de la salud.</p>
                    <p>Accede a tus consultas y resuelve tus dudas desde casa.</p>
                    <a href="/consulta_en_linea" class="button">Ir a Consulta en Línea</a>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card">
                <div class="section-title"><i class="bi bi-file-medical"></i> Historial Clínico Electrónico</div>
                <div class="section-content">
                    <p>Almacena tu historial médico de forma segura y accesible.</p>
                    <p>Consulta diagnósticos, tratamientos y medicamentos recetados.</p>
                    <a href="/historial_clinico" class="button">Ir a Historial Clínico</a>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card">
                <div class="section-title"><i class="bi bi-activity"></i> Seguimiento de Datos de Salud</div>
                <div class="section-content">
                    <p>Registra tus datos de salud, como lecturas de glucosa y presión arterial.</p>
                    <p>Recibe recordatorios para medicamentos y seguimiento de síntomas.</p>
                    <a href="/seguimiento_salud" class="button">Ir a Seguimiento de Salud</a>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card">
                <div class="section-title"><i class="bi bi-chat-dots"></i> Mensajería Segura</div>
                <div class="section-content">
                    <p>Comunícate de forma segura con profesionales de la salud.</p>
                    <p>Gestiona consultas y preguntas frecuentes de manera eficiente.</p>
                    <a href="/mensajeria_segura" class="button">Ir a Mensajería Segura</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function toggleTheme() {
        var body = document.body;
        var themeButton = document.getElementById('themeButton');
        if (body.classList.contains('theme-dark')) {
            body.classList.remove('theme-dark');
            body.classList.add('theme-light');
            themeButton.innerText = 'Modo Oscuro';
        } else {
            body.classList.remove('theme-light');
            body.classList.add('theme-dark');
            themeButton.innerText = 'Modo Claro';
        }
    }
</script>
</body>
</html>