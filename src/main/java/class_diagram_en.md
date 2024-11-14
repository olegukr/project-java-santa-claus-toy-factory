```mermaid
classDiagram
    MainController --> ElfToyController : coordinates
    MainController --> SantaToyController : coordinates
    ElfToyController --> ToyDB : interacts with
    SantaToyController --> ToyDB : interacts with
    ElfToyController --> ToyView : interacts with
    SantaToyController --> ToyView : interacts with
    MainController --> MainView : interacts with

    class MainController {
        +startSession()
        +selectRole(role: String)
    }

    class ElfToyController {
        +addToy(toyDetails: ToyDetails, childType: String)
        +viewAllToys()
        +deleteToy(toyID: String)
    }

    class SantaToyController {
        +viewToysForGoodChildren()
        +viewToysForNaughtyChildren()
        +saveToyDB()
    }

    class Toy {
        -title: String
        -brand: String
        -recommendedAge: String
        -category: String
        -childType: String
    }

    class ToyDB {
        +addToy(toy: Toy)
        +getAllToys(): List~Toy~
        +deleteToy(toyID: String)
        +getToysForChildType(childType: String): List~Toy~
        +saveToyDB()
    }

    class ToyView {
        +displayToyDetails(toy: Toy)
        +displayAllToys(toys: List~Toy~)
        +displayMessage(message: String)
    }

    class MainView {
        +displayRoleSelection()
        +displayElfOptions()
        +displaySantaOptions()
        +displayMessage(message: String)
    }

    ToyDB --> Toy : contains
    ElfToyController --> ToyDB : manipulates
    SantaToyController --> ToyDB : manipulates
    ElfToyController --> ToyView : displays through
    SantaToyController --> ToyView : displays through
    MainController --> MainView : displays through
