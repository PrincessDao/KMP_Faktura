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
            checksum: "1a94630132634bda8e910fd4d7eff371c8d0c86e73ac63fc65466179c57bec35"
        )
    ]
)
