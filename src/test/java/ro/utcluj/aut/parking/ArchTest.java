package ro.utcluj.aut.parking;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("ro.utcluj.aut.parking");

        noClasses()
            .that()
            .resideInAnyPackage("ro.utcluj.aut.parking.service..")
            .or()
            .resideInAnyPackage("ro.utcluj.aut.parking.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..ro.utcluj.aut.parking.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
