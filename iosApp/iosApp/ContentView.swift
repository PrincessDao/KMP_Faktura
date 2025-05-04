import UIKit
import SwiftUI
import ComposeApp

func DotBanner(totalDots: Int, currentIndex: Int, selectedColor: UIColor, unselectedColor: UIColor) -> UIViewController {
    MainViewControllerKt.dotBannerViewController(
        totalDots: Int32(totalDots),
        currentIndex: Int32(currentIndex),
        unselectedColorHex: unselectedColor.toHex(),
        selectedColorHex: selectedColor.toHex()
    )
}

func DotPersonalOffer(totalDots: Int, selectedColor: UIColor, unselectedColor: UIColor) -> UIViewController {
    MainViewControllerKt.dotPersonalOfferViewController(
        totalDots: Int32(totalDots),
        unselectedColorHex: unselectedColor.toHex(),
        selectedColorHex: selectedColor.toHex()
    )
}

extension UIColor {
    func toHex() -> String {
        var red: CGFloat = 0
        var green: CGFloat = 0
        var blue: CGFloat = 0
        var alpha: CGFloat = 0

        self.getRed(&red, green: &green, blue: &blue, alpha: &alpha)

        let rgb = (Int)(red * 255)<<16 | (Int)(green * 255)<<8 | (Int)(blue * 255)<<0
        return String(format:"#%06x", rgb)
    }
}


struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        let vc1 = DotBanner(totalDots: 7, currentIndex: 2, selectedColor: .red, unselectedColor: .gray)
        let vc2 = DotPersonalOffer(totalDots: 7, selectedColor: .green, unselectedColor: .gray)
        let stack = UIStackView()
         stack.axis = .vertical
         stack.distribution = .fillEqually
         stack.translatesAutoresizingMaskIntoConstraints = false

         stack.addArrangedSubview(vc1.view)
         stack.addArrangedSubview(vc2.view)

         let container = UIViewController()
         container.addChild(vc1)
         container.addChild(vc2)

         container.view.addSubview(stack)

         NSLayoutConstraint.activate([
             stack.topAnchor.constraint(equalTo: container.view.topAnchor),
             stack.leadingAnchor.constraint(equalTo: container.view.leadingAnchor),
             stack.trailingAnchor.constraint(equalTo: container.view.trailingAnchor),
             stack.bottomAnchor.constraint(equalTo: container.view.bottomAnchor)
         ])

         vc1.didMove(toParent: container)
         vc2.didMove(toParent: container)

         return container
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



