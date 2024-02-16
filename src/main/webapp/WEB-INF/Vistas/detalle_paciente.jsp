<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Detalle del Paciente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            padding:   0;
            margin:   0;
        }
        .btn-volver {
            margin-top: 20px;
        }
        .paciente-info, .consulta-info {
            margin-top:   20px;
        }
        .historial, .datos-salud {
            margin-left: 60px;
            margin-top: 20px;
            margin-bottom:  50px;
        }
        .btn-nuevo-registro{
            margin-top: 30px;
        }
        .btn-nueva-consulta{
            margin-bottom: 30px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <button class="btn btn-primary btn-volver" onclick="window.history.back();">Volver a la Gestión de Pacientes</button>
    <div class="row">
        <!--Informacion del Paciente y Consultas-->
        <div class="col-md-3">
            <div class="paciente-info">
                <h2>Información del Paciente</h2>
                <p><strong>Nombre:</strong> ${paciente.nombre_paciente} ${paciente.apellidos_paciente}</p>
                <p><strong>Correo Electrónico:</strong> ${paciente.correo_electronico}</p>
                <p><strong>Telefono:</strong> ${paciente.telefono}</p>
                <p><strong>Género:</strong> ${paciente.sexo}</p>
                <p><strong>Direccion:</strong> ${paciente.direccion}</p>
                <p><strong>Fecha de Nacimiento:</strong> ${fechaNacimiento}</p>
            </div>
            <div class="consulta-info">
                <h2>Consultas del Paciente</h2>
                <c:if test="${not empty consultas}">
                    <ul class="list-group">
                        <c:forEach var="consulta" items="${consultas}">
                            <li class="list-group-item">${fechaConsulta} - ${consulta.tipo_consulta}</li>
                        </c:forEach>
                        <button class="btn btn-primary btn-nueva-consulta" onclick="window.location.href='/agregar_consulta?id=${paciente.id_paciente}'">
                            Añadir Nueva Consulta
                        </button>
                    </ul>
                </c:if>
                <c:if test="${empty consultas}">
                    <p>No hay consultas registradas para este paciente.</p>
                    <button class="btn btn-primary btn-nueva-consulta" onclick="./agregar_consulta?id=${paciente.id_paciente}">
                        Añadir Nueva Consulta
                    </button>
                </c:if>
            </div>
        </div>
        <!-- Informacion del historial y Datos de Salud -->
        <div class="col-md-9">
            <div class="historial">
                <h2>Historial del Paciente</h2>
                <c:if test="${not empty historial.diagnosticos}">
                    <ul class="list-group">
                        <c:forEach var="diagnostico" items="${historial.diagnosticos}">
                            <li class="list-group-item">${diagnostico.diagnostico}</li>
                            <li class="list-group-item">${diagnostico.tratamiento}</li>
                        </c:forEach>
                        <button class="btn btn-primary btn-nuevo-registro" onclick="./agregar_registro_historial?id=${paciente.id_paciente}">
                            Añadir Nuevo Registro al Historial
                        </button>
                    </ul>
                </c:if>
                <c:if test="${empty historial.diagnosticos}">
                    <p>No hay datos de historial registrados para este paciente.</p>
                    <button class="btn btn-primary btn-nuevo-registro" onclick="window.location.href='/agregar_registro_historial?id=${paciente.id_paciente}'">
                        Añadir Nuevo Registro al Historial
                    </button>
                </c:if>
            </div>
            <div class="datos-salud">
                <h2>Datos Salud del Paciente</h2>
                <c:if test="${not empty datosSalud}">
                    <ul class="list-group">
                        <c:forEach var="datoSalud" items="${datosSalud}">
                            <li class="list-group-item">${fechaDatosSalud} - ${datoSalud.tipo_dato} - ${datoSalud.valor_dato} ${datoSalud.unidad_medida}</li>
                        </c:forEach>
                    </ul>
                </c:if>
                <c:if test="${empty datosSalud}">
                    <p>No hay datos de salud registrados para este paciente.</p>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>