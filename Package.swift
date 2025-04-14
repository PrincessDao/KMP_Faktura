// swift-tools-version:6.1
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
        .target(
            name: "KMPLibrary",
            path: "Sources"
        )
    ]
)