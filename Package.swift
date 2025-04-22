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
            checksum: "dbc1747d88942d98293e9d4382500acf23390cb6a26d9d1dc9fa8558f7e93be2"
        )
    ]
)
