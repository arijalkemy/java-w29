# Introducción a Git - Cheatsheet

## Comandos Git 

#### Ayuda

- `git help`

#### Comando específico

- `git help add`
- `git help commit`
- `git help <cualquier_comando_git>`

#### Establecer el usuario y el e-mail

- `git config --global user.name "nombre de usuario"`
- `git config --global user.email email@email.com`

#### Eliminar todos los registros que se refieren al usuario y al e-mail

- `git config --global --unset user.name "nombre de usuario"`
- `git config --global --unset user.email email@email.com`

#### Ver la configuración de Git

- `git config --list`

#### Crear un nuevo repositorio

- `git init`

#### Verificar el estado de los archivos/directorios

- `git status` _(muestra el estado de los archivos en su repositorio)_

#### Añadir un archivo

- `git add nombre_archivo_directorio` _(archivo específico)_
- `git add .` _(todos los archivos)_

#### Comitear un archivo/directorio

- `git commit nombre_archivo -m "mensaje del commit"`

#### Remover un archivo o directorio

- `git rm archivo`
- `git rm -r directorio` _(remueve el directorio y los archivos que contiene)_

#### Ver el historial de actividad

- `git log (muestra el historial)`
- `git log -- <ruta del archivo>` _(muestra el historial de un archivo específico)_
- `git log --author=usuario` _(muestra el historial de un usuario en particular)_
 

### Deshacer operaciones 

#### Deshaciendo el cambio local en su directorio de trabajo local

- `git checkout -- archivo` _(solo debe usarse mientras el archivo no se haya añadido todavía a la área de trabajo temporal)_

#### Deshaciendo el cambio local en el área de trabajo temporal (staged area)

- `git reset HEAD archivo` _(debe usarse cuando el archivo ya ha sido añadido en el área temporal)._
- `“Unstaged changes after reset:M archivo”` _(si se muestra el siguiente resultado, el comando reset no ha cambiado el directorio de trabajo)._
- `git checkout nombre_archivo` _(permite realizar el cambio de directorio)._

### Repositorio Remoto

#### Ver los repositorios remotos (para saber a dónde se envían los cambios o de dónde los descargamos)

- `git remote`
- `git remote -v`
- `git remote add origin git@github.com:minombre/archivo-git.git` _(enlaza el repositorio local con un repositorio remoto)._
- `git remote show origin` _(permite ver la información de los repositorios remotos)._
- `git remote rename origin nombre_nuevo` _(renombra un repositorio remoto)._
- `git remote rm nombre_git` _(desvincula un repositorio remoto)._
- `git push -u origin master` _(el primer push en el repositorio debe contener su nombre y branch)._
- `git push` _(los otros pushs no necesitan otras informaciones)._

#### Actualizar el repositorio local según el repositorio remoto

- `git pull` _(actualizar los archivos contra la branch actual)._
- `git fetch` _(obtener los cambios, pero no aplicarlos a la branch actual)._

#### Clonar un repositorio remoto existente

- `git clone git@github.com:minombre/archivo-git.git`

### Branches

#### El master o main es la branch principal de Git. El HEAD es un puntero especial que indica cuál es la branch actual. Por defecto, HEAD apunta a la branch principal, la master.

- `git branch nuevaBranch_nombre` _(crea una nueva branch)._
- `git checkout nuevaBranch_nombre` _(cambia a una branch existente). En este caso, el principal puntero HEAD está apuntando a la branch llamada nuevaBranch_nombre._
- `git checkout -b nuevaBranch_nombre` _(crea una nueva branch y apunta a ella)._
- `git checkout master` _(vuelve a la branch principal-master-)._
- `git merge nuevaBranch_nombre` _(resuelve la unión (merge) entre las branches). Para realizar la unión (merge), debe estar en la branch que debe recibir los cambios._
- `git branch -d nuevaBranch_nombre` _(apagando una branch)._
- `git branch` _(lista branches)._
- `git branch -v` _(lista branches con información de los últimos commits)._
- `git branch --merged` _(lista branches que ya se han unido (merged) con la master)._
- `git branch --no-merged` _(listar branches que no se han unido (merged) con la master)._
- `git pull origin nombreBranch` _(trae los archivos de la branch nombreBranch a la branch donde estas situado actualmente)._
- `git push origin nuevaBranch_nombre` _(crea una branch remota con el mismo nombre)._
- `git merge --abort` o `git reset --merge` _(cuando tenemos problemas con la unión (merge) y queremos deshacerla)_
- `git reset HEAD` _(cuando queremos volver a un commit anterior, si queremos volver a más de un commit, debemos poner el número de commits después de HEAD. Ejemplo: HEAD~2)._
 

#### Reescribiendo la historia
- `git commit --amend -m "Mi nuevo mensaje"` _(cambia los mensajes del commit)._


## Comandos de la terminal

### Limpiar la consola.

- `crtl+l o clear`


### Crear una carpeta.

- `mkdir nombre_de_carpeta`

### Entrar en la carpeta.

- `cd`

### Salir de la carpeta.

- `cd ..`

### Ver lo que hay dentro de la carpeta.

- `ls`

### Borrar archivo

- `rm nombre`

### Borrar directorio y todos los archivos que contiene.

- `rm -r nombre`

### Borrar directorio y todos los archivos que contiene en forma forzada.

- `rm -rf nombre`