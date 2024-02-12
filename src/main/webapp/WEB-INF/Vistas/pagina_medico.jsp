<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Panel de Control del Médico</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            body {
                font-family: 'Roboto', sans-serif;
                background-color: #f8f9fa;
                transition: background-color  0.5s ease, color  0.5s ease;
            }
            .navbar {
                background-color: #007bff;
            }
            .navbar-brand {
                color: white;
            }
            .card {
                border-radius:   10px;
                box-shadow:   0   4px   8px   0 rgba(0,0,0,0.2);
                transition:   0.3s;
            }
            .card:hover {
                box-shadow:   0   8px   16px   0 rgba(0,0,0,0.2);
            }
            .card-header {
                background-color: #007bff;
                color: white;
                font-weight: bold;
            }
            .btn-primary {
                background-color: #007bff;
                border-color: #007bff;
            }
            .btn-primary:hover {
                background-color: #0056b3;
                border-color: #0056b3;
            }
            .cards-container{
                margin-top:  2rem;
            }
            .theme-dark {
                background-color: #343a40;
                color: #fff;
            }
            .theme-dark .navbar {
                background-color: #343a40;
            }
            .theme-dark .card {
                background-color: #495057;
                color: #fff;
            }
            .theme-dark .btn-primary {
                background-color: #007bff;
                border-color: #007bff;
            }
            .theme-dark .btn-primary:hover {
                background-color: #0056b3;
                border-color: #0056b3;
            }
        </style>
    </head>
    <body>
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">Panel de Control del Médico</a>
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
        <div class="row cards-container">
            <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal"><i class="bi bi-people-fill"></i> Gestión de Pacientes</h4>
                    </div>
                    <div class="card-body">
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>Acceso a perfiles de pacientes</li>
                            <li>Programación de consultas</li>
                            <li>Seguimiento de pacientes</li>
                        </ul>
                        <a href="./gestion_pacientes" class="btn btn-primary">Ir a Gestión de Pacientes</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal"><i class="bi bi-calendar-event"></i> Gestión de Citas</h4>
                    </div>
                    <div class="card-body">
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>Programación de citas en línea</li>
                            <li>Recordatorios automáticos</li>
                        </ul>
                        <a href="./gestion_citas" class="btn btn-primary">Ir a Gestión de Citas</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal"><i class="bi bi-graph-up"></i> Análisis de Datos</h4>
                    </div>
                    <div class="card-body">
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>Informes y análisis de salud</li>
                            <li>Eficiencia en la atención y resultados de tratamientos</li>
                        </ul>
                        <a href="./analisis_datos" class="btn btn-primary">Ir a Análisis de Datos</a>
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