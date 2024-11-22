```mermaid
classDiagram
    %% Controllers
    class ExportToFileCSV {
        +String filePath
        +void export(String filePath)
    }

    class MainController {
        +ToyController toyController
        +MainView mainView
        +void main(String[] args)
    }

    class ToyController {
        +IDatabase database
        +void addToy(Toy toy)
        +boolean removeToy(String toyId)
        +List~Toy~ listToys()
        +void postBadToy(BadToyDto badToyDto)
        +void postGoodToy(GoodToyDto goodToyDto)
        +List~GoodToy~ getGoodToys()
        +List~BadToy~ getBadToys()
        +boolean deleteGoodToy(String id)
        +boolean deleteBadToy(String id)
    }

    %% Database
    class BadToyDatabase {
        -List~BadToy~ badToys
        +void add(BadToy toy)
        +boolean remove(String toyId)
        +List~BadToy~ getAll()
    }

    class GoodToyDatabase {
        -List~GoodToy~ goodToys
        +void add(GoodToy toy)
        +boolean remove(String toyId)
        +List~GoodToy~ getAll()
    }

    class IDatabase {
        <<interface>>
        +void add(Object obj)
        +boolean remove(String id)
        +List~Object~ getAll()
    }

    class ToysDB {
        -List~Toy~ allToys
        +void addToy(Toy toy)
        +boolean removeToy(String toyId)
        +List~Toy~ listToys()
    }

    %% DTO
    class BadToyDto {
        -String id
        -String name
        -String reason
        +String getId()
        +String getName()
        +String getReason()
    }

    class GoodToyDto {
        -String id
        -String name
        -String brand
        -String recommendedAge
        -String category
        +String getId()
        +String getName()
        +String getBrand()
        +String getRecommendedAge()
        +String getCategory()
    }

    %% Models
    class Toy {
        -String id
        -String name
        +Toy(String id, String name)
        +String getId()
        +String getName()
    }

    class BadToy {
        -String id
        -String name
        -String reason
        -String severityLevel
        -boolean needsFix
        +BadToy(String id, String name, String reason, String severityLevel, boolean needsFix)
        +String getReason()
        +String getSeverityLevel()
        +boolean isNeedsFix()
        +void setNeedsFix(boolean needsFix)
        +String toString()
    }

    class GoodToy {
        -String id
        -String name
        -String brand
        -String recommendedAge
        -String category
        -boolean isAvailable
        +GoodToy(String id, String name, String brand, String recommendedAge, String category, boolean isAvailable)
        +String getBrand()
        +String getRecommendedAge()
        +String getCategory()
        +boolean getIsAvailable()
        +void setAvailability(boolean availability)
        +String toString()
    }

    %% Repository
    class ToyRepository {
        -List~Toy~ toys
        +void addToy(Toy toy)
        +boolean removeToy(String id)
        +List~Toy~ findAll()
    }

    %% Singletons
    class BadToyDatabaseSingleton {
        -static BadToyDatabase instance
        +static BadToyDatabase getInstance()
    }

    class GoodToyDatabaseSingleton {
        -static GoodToyDatabase instance
        +static GoodToyDatabase getInstance()
    }

    class ToyRepositorySingleton {
        -static ToyRepository instance
        +static ToyRepository getInstance()
    }

    %% Views
    class View {
        +void render()
    }

    class ElfView {
        -static ToyController controller
        +static void index()
        +static void selectChild()
        -static void postBadToy()
        +static void postGoodToy()
        -static void showGoodToys()
        -static void showBadToys()
        -static void showAllToys()
        -static void deleteToy()
        +static void ClouseSession()
        +static void addToyResponse()
    }

    class MainView {
        -Inventory inventory
        +MainView(Inventory inventory)
        +void displayMainMenu()
        +void listAllToys()
        +void selectOption()
    }

    class SantaView {
        -Inventory inventory
        +SantaView(Inventory inventory)
        +void displaySantaDashboard()
        +void approveToyDelivery()
        +void generateGoodToyList()
    }

    %% App Entry Point
    class App {
        +MainController mainController
        +static void main(String[] args)
    }

    %% Relationships
    App --> MainController
    View <|-- ElfView : Inheritance
    View <|-- MainView : Inheritance
    View <|-- SantaView : Inheritance

    IDatabase <|.. BadToyDatabase : Implementation
    IDatabase <|.. GoodToyDatabase : Implementation
    IDatabase <|.. ToysDB : Implementation

    Toy <|-- BadToy : Inheritance
    Toy <|-- GoodToy : Inheritance

    ToysDB o-- Toy : Aggregation
    BadToyDatabase o-- BadToy : Aggregation
    GoodToyDatabase o-- GoodToy : Aggregation

    ElfView ..> ToyController : Dependency
    ElfView ..> BadToyDto : Dependency
    ElfView ..> GoodToyDto : Dependency

    MainController --> MainView : Association
    MainController --> ToyController : Association
    MainView o-- ToyController : Aggregation
    SantaView o-- ToyController : Aggregation

    ToyRepositorySingleton --> ToyRepository
    BadToyDatabaseSingleton --> BadToyDatabase
    GoodToyDatabaseSingleton --> GoodToyDatabase 
    ExportToFileCSV --> ToyController
    ToyController --> ToyRepository
    ToyRepository --> GoodToyDatabaseSingleton
    ToyRepository --> BadToyDatabaseSingleton