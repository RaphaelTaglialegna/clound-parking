package br.floreia.parking.controller.test;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

public abstract class AbstractContainerBase {

    private static final String DOCKER_IMAGE_NAME = "postgres:10-alpine";
    private static final String POSTGRESQL_USER = "admin";
    private static final String POSTGRESQL_PASSWORD = "123456";
    private static final String POSTGRESQL_DATABASE = "parking";

    protected static final PostgreSQLContainer CONTAINER;
    private static final TemporalUnit SECONDS = null;

    static {
        DockerImageName imgName = DockerImageName.parse(DOCKER_IMAGE_NAME).asCompatibleSubstituteFor("postgres");

        CONTAINER = (PostgreSQLContainer) new PostgreSQLContainer(imgName)
                .withDatabaseName(POSTGRESQL_DATABASE)
                .withUsername(POSTGRESQL_USER)
                .withPassword(POSTGRESQL_PASSWORD)
                .withEnv("POSTGRESQL_DATABASE", POSTGRESQL_DATABASE)
                .withEnv("POSTGRESQL_USER", POSTGRESQL_USER)
                .withEnv("POSTGRESQL_PASSWORD", POSTGRESQL_PASSWORD)
                .withExposedPorts(PostgreSQLContainer.POSTGRESQL_PORT);

        CONTAINER.setWaitStrategy(Wait.defaultWaitStrategy()
                .withStartupTimeout(Duration.of(60, SECONDS)));

        CONTAINER.start();
    }
}
