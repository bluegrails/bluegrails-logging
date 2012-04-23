


class LoggingGrailsPlugin {
  def version = "2.2"
  def grailsVersion = "2.0.1 > *"
  def dependsOn = [:]

  def author = "Richard Vowles"
  def authorEmail = "richard@bluetrainsoftware.com"
  def title = "Fake Implementation of Grails Logging"
  def description = 'Fake implementation of Grails Logging'

  def documentation = ""

  def pluginExcludes = [
          'grails-app/controllers/**',
          'grails-app/i18n/**',
          'web-app/**'
  ]

}
