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
            checksum: "cd14f83c9104f86d738d51a10446d093356434937849360be51ac94d2a4f8863"
        )
    ]
)
