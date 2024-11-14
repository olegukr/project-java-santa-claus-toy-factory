```mermaid
flowchart TD
    A[Iniciar sesion de trabajo] --> B{Seleccionar tipo de sesion}
    B -->|Elfo| C[Gestor de juguetes Elfo]
    B -->|Santa| N[Gestor de juguetes Santa]

    %% Elfo Actions
    C --> D{Seleccionar opcion}
    D -->|1: Anadir juguete| E[Anadir juguete]
    E --> F{Para nino}
    F -->|Bueno| G[Detalles del juguete bueno]
    F -->|Malo| H[Detalles del juguete malo]
    G --> I[Juguete anadido con exito] --> C
    H --> I

    D -->|2: Ver todos los juguetes| J[Lista de juguetes] --> C
    D -->|3: Eliminar juguete| K[Ingresar ID del juguete]
    K --> L[Juguete eliminado con exito] --> C
    D -->|4: Cerrar sesion| M[Sesion cerrada]

    %% Santa Claus Actions
    N --> O{Seleccionar opcion}
    O -->|1: Juguetes buenos| P[Lista de juguetes buenos] --> N
    O -->|2: Juguetes malos| Q[Lista de juguetes malos] --> N
    O -->|3: Guardar lista| R[Lista guardada] --> N
    O -->|4: Cerrar sesion| S[Sesion cerrada]

    %% Exit Points
    M --> T[End]
    S --> T[End]
