<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Creacion Historial Paciente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="my-4">Creacion Historial Paciente</h2>
    <form action="./agregar_historial" method="post">
        <div class="form-group">
            <label for="paciente">Selecciona al paciente:</label>
            <select name="idPaciente" id="paciente" class="form-control">
                <c:forEach items="${pacientes}" var="paciente">
                    <option value="${paciente.id_paciente}">${paciente.nombre_paciente} ${paciente.apellidos_paciente}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="medico">Selecciona al médico:</label>
            <select name="medico" id="medico" class="form-control">
                <c:forEach items="${medicos}" var="medico">
                    <option value="${medico.id_profesional}">${medico.nombre_profesional} ${medico.apellidos_profesional}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Crear Historial</button>
    </form>
</div>
</body>
</html>
