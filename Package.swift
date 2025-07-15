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
            checksum: "74695cda486ea63dfe714077114265950f84d9551b1dda687f1a9b05ad6a67fa"
        )
    ]
)
