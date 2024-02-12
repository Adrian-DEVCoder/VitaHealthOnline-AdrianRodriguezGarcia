<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="dateFormat" value="yyyy-MM-dd" />
<html>
<head>
    <title>VitaHealth - Online | Gestion Pacientes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .navbar {
            background-color: #f8f9fa;
            margin-bottom: 20px;
        }

        .nav-item {
            margin-right: 1rem;
        }

        .paciente-card {
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            max-width: 100%;
        }

        .paciente-foto {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            object-fit: cover;
            margin-bottom: 20px;
        }

        .paciente-edad {
            margin-right: 20px;
        }

        .container > * {
            margin-bottom: 20px;
        }

        .container > :last-child {
            margin-bottom: 0;
        }

        .ver-detalles-btn {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .ver-detalles-btn:hover {
            background-color: #0056b3;
            color: #f0f0f0;
            text-decoration: none;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">VitaHealth</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="./pagina_medico">Panel de Control</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="container-titulo">
        <h1>Gestión de Pacientes</h1>
    </div>
    <div class="container-buscador">
        <input type="text" class="form-control" placeholder="Nombre del paciente...">
    </div>
    <c:forEach var="paciente" items="${pacientes}">
        <div class="paciente-card">
            <div class="paciente-info">
                <img src="https://definicion.de/wp-content/uploads/2019/07/perfil-de-usuario.png" alt="Foto del paciente" class="paciente-foto">
                <div>
                    <h3>${paciente.nombre_paciente} ${paciente.apellidos_paciente}</h3>
                    <p>Correo Electronico: ${paciente.correo_electronico}</p>
                    <p>Género: ${paciente.sexo}</p>
                    <p>Localidad: ${paciente.direccion}</p>
                    <p>Fecha de nacimiento: <fmt:formatDate value="${paciente.fecha_nacimiento}" pattern="${dateFormat}" /></p>
                </div>
            </div>
            <a href="/detalle_paciente?id=${paciente.id_paciente}" class="ver-detalles-btn">Ver Detalles</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
