import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val a = "napplelabs" % "sbtgrowlplugin" % "1.0"
}