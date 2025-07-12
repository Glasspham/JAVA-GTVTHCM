# Flowchart: User Interactions with Gym Management System

```mermaid
graph TD
    A[Start] --> B[Login]
    B -->|Admin| C[Admin Menu]
    B -->|Trainer| D[Trainer Menu]
    B -->|Member| E[Member Menu]
    C --> C1[Manage Members]
    C --> C2[Manage Trainers]
    C --> C3[Manage Plans]
    C --> C4[Reports]
    C --> C5[Save/Load Data]
    C --> F[Logout]
    D --> D1[Assign Workout Schedule]
    D --> D2[Track Attendance]
    D --> D3[View Members]
    D --> F
    E --> E1[View Workout Schedules]
    E --> E2[Update Progress]
    E --> E3[Renew Subscription]
    E --> F
    F --> B
```
[![](https://mermaid.ink/img/pako:eNplk11vmzAUhv-K5YteQYoJAcbFpDQkV400LV0rrezCxQ6xCseRMWu7KP99BwyNst1x3vc5n8gnWmohaUZ93y-g1LBXVVYAITX_0J3NyF69S1HAYO9r_VYeuLHkIe8ZQpbPBd1ZVAr6i_j-V3KHwr2uFKDgkDvUyVI0CgZghYCLthK6a-rBcAXSDFyO3BT_T25l8zKCawTH8IpbuXastznwSo5JbT_qDVmFF2PsMznzi_Ot5jDJEcrf5VEbOymLfnv-W97eay5Izi13xsYdAe_3OU3uluqnWbatqoA8afOKBNmVBym6WrrUPHR7l69kaa0EwaGcrH6uRyXfrhfZuAZrdww2Mf-WH-l1X__HUXCLyxldGdlOznzYDzB31720pVFHqzRcNdm4f1wA9WhllKCZNZ30aCNNw_uQnnqwoPYgGxw7w08h97yr8RIFnDHtyOGn1s2UaXRXHaagG-bKFa8MvxB4BGlWugNLMxamQwmaneg7hvEsTAMWsDCOIjaPIo9-oBotZvNFHLM4jJKEMRaePfpnaBrMvkRhGMRxGiRJFKdp4lEplNVm657B8BrOfwHADu3v?type=png)](https://mermaid.live/edit#pako:eNplk11vmzAUhv-K5YteQYoJAcbFpDQkV400LV0rrezCxQ6xCseRMWu7KP99BwyNst1x3vc5n8gnWmohaUZ93y-g1LBXVVYAITX_0J3NyF69S1HAYO9r_VYeuLHkIe8ZQpbPBd1ZVAr6i_j-V3KHwr2uFKDgkDvUyVI0CgZghYCLthK6a-rBcAXSDFyO3BT_T25l8zKCawTH8IpbuXastznwSo5JbT_qDVmFF2PsMznzi_Ot5jDJEcrf5VEbOymLfnv-W97eay5Izi13xsYdAe_3OU3uluqnWbatqoA8afOKBNmVBym6WrrUPHR7l69kaa0EwaGcrH6uRyXfrhfZuAZrdww2Mf-WH-l1X__HUXCLyxldGdlOznzYDzB31720pVFHqzRcNdm4f1wA9WhllKCZNZ30aCNNw_uQnnqwoPYgGxw7w08h97yr8RIFnDHtyOGn1s2UaXRXHaagG-bKFa8MvxB4BGlWugNLMxamQwmaneg7hvEsTAMWsDCOIjaPIo9-oBotZvNFHLM4jJKEMRaePfpnaBrMvkRhGMRxGiRJFKdp4lEplNVm657B8BrOfwHADu3v)
- **Admin**: Quản lý hội viên, huấn luyện viên, gói tập, báo cáo, lưu/tải dữ liệu.
- **Trainer**: Phân công lịch tập, chấm công, xem hội viên.
- **Member**: Xem lịch tập, cập nhật tiến độ, gia hạn gói tập.
- **Logout**: Quay lại màn hình đăng nhập.

> Bạn có thể copy đoạn mã Mermaid trên vào [Mermaid Live Editor](https://mermaid-js.github.io/mermaid-live-editor/) để xem sơ đồ trực quan.
