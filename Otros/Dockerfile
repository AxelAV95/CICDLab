FROM maven:3.8.6-openjdk-17

# Actualiza los paquetes e instala Docker
RUN apt-get update && apt-get install -y docker.io

# Configura el ENTRYPOINT para ejecutar los comandos pasados como argumentos
ENTRYPOINT ["/bin/sh", "-c"]

# Comando predeterminado
CMD ["mvn"]
