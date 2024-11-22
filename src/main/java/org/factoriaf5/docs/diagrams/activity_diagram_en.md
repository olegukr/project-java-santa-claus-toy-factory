```mermaid
flowchart TD
    A[Start work session] --> B{Select session type}
    B -->|Elf| C[Toy Manager Elf]
    B -->|Santa| N[Toy Manager Santa]

    %% Elf Actions
    C --> D{Select option}
    D -->|1: Add toy| E[Add toy]
    E --> F{For child}
    F -->|Good| G[Details for good child toy]
    F -->|Naughty| H[Details for naughty child toy]
    G --> I[Toy added successfully] --> C
    H --> I
    

    D -->|2: View all toys| J[Show toy list] --> C
    D -->|3: Delete toy| K[Enter toy ID]
    K --> L[Toy deleted successfully] --> C
    D -->|4: Logout| M[Session closed] --> B

    %% Santa Claus Actions
    N --> O{Select option}
    O -->|1: Toys for good children| P[List of toys for good children] --> N
    O -->|2: Toys for naughty children| Q[List of toys for naughty children] --> N
    O -->|3: Save list| R[List saved] --> N
    O -->|4: Logout| S[Session closed] --> B

    %% Exit Points
    B --> T[End]
