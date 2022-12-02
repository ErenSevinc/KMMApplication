//
//  DependencyInjector.swift
//  iosApp
//
//  Created by Sevinc, Eren on 29.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

func startKoin() {
    _koin = DependencyInjectorKt.doInitKoin().koin
}

private var _koin: Koin_coreKoin?

var koin: Koin_coreKoin {
    return _koin!
}

extension Koin_coreKoin {
    func get() -> MoviesPageViewModel {
        return koin.getDependency(objCClass: MoviesPageViewModel.self) as! MoviesPageViewModel
    }
}
