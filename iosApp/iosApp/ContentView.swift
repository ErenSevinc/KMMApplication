import SwiftUI
import shared

struct ContentView: View {
    //let greeting = Greeting()
    //@State var greet: String = "Eren"
    //MoviesResult?
    //= MoviesResult(
    //page: nil,
    //totalResults: nil,
    //totalPages: nil,
    //results: NSMutableArray()
    //)
    
    /*
    func load() {
        
        greeting.getPopularMovies { result, error in
            if let result = result {
                self.greet = result
            } else if let error = error {
                greet = "Error \(error)"
                
                /*MoviesResult(
                    page: nil,
                    totalResults: nil,
                    totalPages: nil,
                    results: NSMutableArray()
                )
                 
                 */
            }
        }
    }
     */

    /*
    let impl = ApiServiceImpl()
    let dataRepo = DataRepository(service: impl)
    let useCase = GetPopularMoviesUseCase(repository: dataRepo)
    let vModel = MoviesPageViewModel(getPopularMoviesUseCase: useCase)
*/

    
    var body: some View {
        
        Text("Eren")
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
