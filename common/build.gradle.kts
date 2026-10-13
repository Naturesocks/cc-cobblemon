plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
}

architectury {
    common("neoforge", "fabric")
}

loom {
    silentMojangMappingsLicense()
}

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings(loom.officialMojangMappings())
    modImplementation("com.cobblemon:mod:${property("cobblemon_version")}") { isTransitive = false }

    testImplementation("org.junit.jupiter:junit-jupiter-api:${property("junit_version")}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${property("junit_version")}")

    minecraftRuntimeLibraries("org.squiddev:Cobalt:0.7.3")
    minecraftRuntimeLibraries("com.jcraft:jzlib:1.1.3")
    minecraftRuntimeLibraries("io.netty:netty-codec-http:4.2.13.Final")
    minecraftRuntimeLibraries("io.netty:netty-codec-socks:4.2.13.Final")
    minecraftRuntimeLibraries("io.netty:netty-handler-proxy:4.2.13.Final")

    modImplementation("cc.tweaked:cc-tweaked-${property("minecraft_version")}-common-api:${property("cc_version")}")
}

tasks.test {
    useJUnitPlatform()
}
