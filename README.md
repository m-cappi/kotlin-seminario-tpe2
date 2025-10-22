# KotlinTPE - Configuración de la API de Juegos

Este proyecto utiliza la API de RAWG para obtener información de videojuegos. Para que la aplicación funcione correctamente, es necesario configurar la clave de la API (`GAMES_API_KEY`) en el archivo `build.gradle`.

## Reemplazar `GAMES_API_KEY`

1. Abre el archivo `app/build.gradle` de tu proyecto.
2. Busca la sección `productFlavors`. Por ejemplo:

```kotlin
productFlavors {
    create("dev") {
        applicationIdSuffix = ".dev"
        versionNameSuffix = "-dev"
        dimension = "environment"
        buildConfigField(
            "String", "GAMES_API_URL",
            "\"https://api.rawg.io/api/\""
        )
        buildConfigField(
            "String", "GAMES_API_KEY",
            "\"placeholder\""
        )
    }
}
```

3. Reemplaza el valor de `GAMES_API_KEY` por tu propia clave obtenida de RAWG:

```kotlin
buildConfigField(
    "String", "GAMES_API_KEY",
    "\"TU_NUEVA_API_KEY_AQUI\""
)
```

4. Guarda el archivo y sincroniza el proyecto con Gradle (`Sync Project with Gradle Files` en Android Studio).

