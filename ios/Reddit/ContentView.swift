import Shared
import SwiftUI

struct ContentView: View {
  @State
  private var result: String = ""

  var body: some View {
    VStack {
      Text(Platform().name())
      Text(SerializationTest().canWeSerialize())
      Button("Press me") {
        Task {
          RequestTest().doRequest(completionHandler: { result, error in
            self.result = String(describing: result)
          })
        }
      }
      Text(result)
    }
  }
}
