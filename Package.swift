// swift-tools-version:5.6
import PackageDescription

let package = Package(
    name: "KMPLibrary",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "KMPLibrary",
            targets: ["KMPLibrary"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "KMPLibrary",
            url: "https://github.com/PrincessDao/KMP_Faktura/releases/download/0.0.1/KMPLibrary.xcframework.zip",
            checksum: "66bb1898962fa0d7b8202f12eb52c5a7def2ae966c9640298a57863d246cb0b5"
        )
    ]
)
