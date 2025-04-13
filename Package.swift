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
        .binaryTarget(
            name: "KMPLibrary",
            path: "./kmp/build/XCFrameworks/release/KMPLibrary.xcframework"
        )
    ]
)