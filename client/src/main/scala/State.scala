/*
 * Copyright 2014-2020 47 Degrees <https://47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.scalaexercises.client
package state

import model.Exercises._
import actions._

object State {
  def update(s: State, a: Action): State = a match {
    case Start                        => Nil
    case SetState(newState)           => newState
    case UpdateExercise(method, args) => updateByMethod(s, method, args)
    case CompileExercise(method)      => evaluate(s, method)
    case CompilationOk(method)        => setAsSolved(s, method)
    case CompilationFail(method, msg) => setAsErrored(s, method)
    case _                            => s
  }
}
