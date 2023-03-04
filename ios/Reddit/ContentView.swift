import Shared
import SwiftUI

struct ContentView: View {
  @State
  private var result: String = ""

  var body: some View {
    NavigationView {
      SubRedditScreen()
          .environmentObject(SubRedditModel())
          .navigationBarTitle("all")
    }
  }
}
