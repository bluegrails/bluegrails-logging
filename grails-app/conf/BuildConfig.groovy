grails.war.resources = { stagingDir ->
    def clazz = Class.forName("nz.ac.auckland.war.grails.GrailsWarProcessResources")

    clazz.processWarResources.delegate = delegate
    clazz.processWarResources.resolveStrategy = Closure.DELEGATE_FIRST
    clazz.processWarResources(stagingDir)

    // start deleting files that shouldn't be there
    File w = new File("${stagingDir}/WEB-INF/lib")
    w.eachFileMatch(groovy.io.FileType.FILES, ~/hsqldb-.*\.jar/) { File f ->
        f.delete()
    }

    File baseConfig = new File("${stagingDir}/META-INF/baseconfig")
    baseConfig.mkdirs()
    ["myTest-war.properties", "myTest.properties", "cacerts", "logback.xml"].each { String confFile ->
        copy(file: "deploy/$confFile",
                tofile: "${stagingDir}/META-INF/baseconfig/$confFile")
    }
}


grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        //mavenRepo "https://waterfall.auckland.ac.nz/nexus/content/groups/public"
    }


}
