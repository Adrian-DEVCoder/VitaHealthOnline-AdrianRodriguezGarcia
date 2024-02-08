<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08/02/2024
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Perfil del Paciente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Editar Perfil del Paciente</h2>
    <form action="./guardarCambios" method="post">
        <div class="form-group">
            <label for="nombrePaciente">Nombre del Paciente:</label>
            <input type="text" class="form-control" id="nombrePaciente" name="nombrePaciente" value="${paciente.nombrePaciente}">
        </div>
        <div class="form-group">
            <label for="apellidosPaciente">Apellidos del Paciente:</label>
            <input type="text" class="form-control" id="apellidosPaciente" name="apellidosPaciente" value="${paciente.apellidosPaciente}">
        </div>
        <div class="form-group">
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>
            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="${paciente.fechaNacimiento}">
        </div>
        <div class="form-group">
            <label for="sexo">Sexo:</label>
            <input type="text" class="form-control" id="sexo" name="sexo" value="${paciente.sexo}">
        </div>
        <div class="form-group">
            <label for="direccion">Dirección:</label>
            <input type="text" class="form-control" id="direccion" name="direccion" value="${paciente.direccion}">
        </div>
        <div class="form-group">
            <label for="correoElectronico">Correo Electrónico:</label>
            <input type="email" class="form-control" id="correoElectronico" name="correoElectronico" value="${paciente.correoElectronico}">
        </div>
        <div class="form-group">
            <label for="telefono">Teléfono:</label>
            <input type="text" class="form-control" id="telefono" name="telefono" value="${paciente.telefono}">
        </div>
        <div class="form-group">
            <label for="nombreUsuario">Nombre de Usuario:</label>
            <input type="text" class="form-control" id="nombreUsuario" name="nombreUsuario" value="${usuario.nombre}">
        </div>
        <div class="form-group">
            <label for="contrasena">Contraseña:</label>
            <input type="password" class="form-control" id="contrasena" name="contrasena" value="${usuario.contrasena}">
        </div>
        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
    </form>
</div>
</body>
</html>

