import Shared
import SwiftUI

struct ContentView: View {

  var body: some View {
    VStack {
      Text(Platform().name())
      Text(SerializationTest().canWeSerialize())
    }
  }
}
