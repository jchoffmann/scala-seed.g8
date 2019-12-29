// *****************************************************************************
// Projects
// *****************************************************************************

lazy val root =
  project
    .in(file("."))
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        library.pureConfig,
        library.scalaTest % Test
      ),
      publishArtifact := false
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      val pureConfig = "0.12.2"
      val scalaTest  = "3.1.0"
    }
    val pureConfig = "com.github.pureconfig" %% "pureconfig" % Version.pureConfig
    val scalaTest  = "org.scalatest"         %% "scalatest"  % Version.scalaTest
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings =
  commonSettings ++
    scalafmtSettings ++
    commandAliases

lazy val commonSettings =
  Seq(
    name := "hello-world",
    scalaVersion := "2.13.1",
    organization := "com.example"
  )

lazy val scalafmtSettings =
  Seq(
    scalafmtOnCompile := true
  )

lazy val commandAliases =
  addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt") ++
    addCommandAlias("check", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")
