
# Guía de configuración de infraestructura y herramientas

## Crear regla de firewall en Google Cloud
```bash
gcloud compute firewall-rules create permitir-8080-9000-global \
    --allow=tcp:8080,tcp:9000 \
    --source-ranges=0.0.0.0/0 \
    --description="Permitir tráfico en los puertos 8080 y 9000 para todas las instancias"
```

## Verificar regiones disponibles para crear instancias
```bash
gcloud org-policies describe constraints/gcp.resourceLocations --project ID_PROYECTO
```

## Crear una instancia en Google Cloud
```bash
gcloud compute instances create my-vm-instance \
    --zone=us-east1-b \
    --machine-type=e2-medium \
    --image-family=debian-11 \
    --image-project=debian-cloud \
    --subnet=default
```

## Instalar Java
```bash
sudo apt update
sudo apt install openjdk-17-jre
```

## Instalar Jenkins
```bash
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc]" \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins
```

### Acceder a Jenkins
- **URL**: `IPPUBLICA:8080`

### Obtener la contraseña inicial de Jenkins
```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```
Ejemplo de salida: `d87d33c0defc406997049c500241af00`

## Agregar credenciales de Docker Hub en Jenkins
1. Ve a **Administrar Jenkins** > **Administrar Credenciales** > **(global)** > **Agregar credenciales**.
2. Selecciona **Username with password** como tipo de credencial.
3. Ingresa tu nombre de usuario y contraseña de Docker Hub o de tu registro privado.
4. Asigna un ID único, por ejemplo: `docker-cred`.

## Generar un Token de Acceso Personal en GitHub
1. Inicia sesión en tu cuenta de GitHub.
2. Haz clic en tu avatar (esquina superior derecha) y selecciona **Configuración**.
3. En el menú de la izquierda, selecciona **Desarrollador** > **Tokens de acceso personal**.
4. Haz clic en **Generar nuevo token**.
5. Proporciona una descripción para el token, por ejemplo: `Integración con Jenkins`.
6. Selecciona los alcances (**scopes**) necesarios; para acceso completo a repositorios, marca **repo**.
7. Haz clic en **Generar token** y copia el token generado (no podrás verlo nuevamente).

### Agregar el Token como credencial en Jenkins
1. Accede al panel de Jenkins.
2. Navega a **Manage Jenkins** > **Manage Credentials** > **(global)** > **Add Credentials**.
3. Selecciona **Username with password** como tipo de credencial.
4. En **Username**, ingresa tu nombre de usuario de GitHub.
5. En **Password**, pega el Token de Acceso Personal que generaste.
6. Asigna un ID único a la credencial: `github`.

## Instalar el plugin Docker Pipelines en Jenkins
1. Ve a **Administrar Jenkins** > **Plugins** > **Available plugins**.
2. Busca **Docker Pipelines** e instálalo.
3. Reinicia Jenkins si es necesario.

## Instalar Docker
```bash
sudo apt update
sudo apt install docker.io
```

### Agregar usuarios al grupo Docker (opcional en Debian)
```bash
sudo su -
usermod -aG docker jenkins
usermod -aG docker ubuntu
sudo usermod -aG docker $USER
systemctl restart docker
```

## Reiniciar Jenkins
- **URL para reiniciar**: `IPPUBLICA:8080/restart`

## Instalar SonarQube
```bash
apt install unzip
adduser sonarqube
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.4.0.54424.zip
unzip *
chmod -R 755 /home/sonarqube/sonarqube-9.4.0.54424
chown -R sonarqube:sonarqube /home/sonarqube/sonarqube-9.4.0.54424
cd sonarqube-9.4.0.54424/bin/linux-x86-64/
./sonar.sh start
```

### Acceder a SonarQube
- **URL**: `IPPUBLICA:9000`
- **Usuario**: `admin`
- **Contraseña inicial**: `admin` (cámbiala tras el primer inicio de sesión).
```

Este archivo `README.md` está organizado con secciones claras, bloques de código en formato Markdown y pasos numerados donde aplica. Puedes copiarlo directamente a un archivo con extensión `.md` y usarlo como guía en un repositorio o documentación.
