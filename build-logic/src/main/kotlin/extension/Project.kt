package extension

import model.Config

val config = Config(
    version = Config.Version(
        major = 2,
        minor = 0,
        patch = 0,
        release = Config.Release.Snapshot(
            number = 4
        )
    ),
    android = Config.Android(
        compileSdk = 34,
        targetSdk = 34,
        minSdk = 24
    ),
    group = "com.neoutils.highlight",
)
