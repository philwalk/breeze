Common.commonSettings

name := "breeze-natives"

libraryDependencies ++= Seq(
  ("com.github.fommil.netlib" % "all" % "1.1.2").pomOnly()
)

// see https://github.com/typesafehub/scalalogging/issues/23
testOptions in Test += Tests.Setup(
  classLoader =>
    classLoader
      .loadClass("org.slf4j.LoggerFactory")
      .getMethod("getLogger", classLoader.loadClass("java.lang.String"))
      .invoke(null, "ROOT"))
