<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Detalle del Paciente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            padding:   0; /* Elimina el padding predeterminado del body */
            margin:   0; /* Elimina el margin predeterminado del body */
        }
        .btn-volver {
            position: fixed; /* Hace que el botón se mantenga en la misma posición incluso al desplazarse */
            top:   20px; /* Mueve el botón un poco hacia abajo para no estar pegado al borde superior */
            left:   20px; /* Mueve el botón un poco hacia la derecha para no estar pegado al borde izquierdo */
            z-index:   1; /* Asegura que el botón esté por encima de otros elementos */
        }
        .paciente-info, .consulta-info {
            margin-top:   60px; /* Añade un margen superior para evitar que el contenido se superponga con el botón */
        }
        .add-buttons {
            margin-top:  20px; /* Añade un margen superior para los botones de añadir */
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
                            <li class="list-group-item">${consulta.fecha} - ${consulta.tipo_consulta}</li>
                        </c:forEach>
                        <button class="btn btn-primary btn-nueva-consulta" onclick="window.location.href='/agregar_consulta?id=${paciente.id}'">
                            Añadir Nueva Consulta
                        </button>
                    </ul>
                </c:if>
                <c:if test="${empty consultas}">
                    <p>No hay consultas registradas para este paciente.</p>
                    <button class="btn btn-primary btn-nueva-consulta" onclick="./agregar_consulta?id=${paciente.id}">
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
                        <button class="btn btn-primary btn-nuevo-registro" onclick="./agregar_registro_historial?id=${paciente.id}">
                            Añadir Nuevo Registro al Historial
                        </button>
                    </ul>
                </c:if>
                <c:if test="${empty historial.diagnosticos}">
                    <p>No hay datos de historial registrados para este paciente.</p>
                    <button class="btn btn-primary btn-nuevo-registro" onclick="window.location.href='/agregar_registro_historial?id=${paciente.id}'">
                        Añadir Nuevo Registro al Historial
                    </button>
                </c:if>
            </div>
            <div class="datos-salud">
                <h2>Datos Salud del Paciente</h2>
                <c:if test="${not empty datosSalud}">
                    <ul class="list-group">
                        <c:forEach var="datoSalud" items="${datosSalud}">
                            <li class="list-group-item">${datoSalud.fecha_dato} - ${datoSalud.tipo_dato} - ${datoSalud.valor_dato} - ${datoSalud.unidad_medida}</li>
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