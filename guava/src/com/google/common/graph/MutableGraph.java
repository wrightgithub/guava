/*
 * Copyright (C) 2014 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/**
 * A subtype of {@link Graph} which permits mutations.
 * Users should generally use the {@link Graph} interface where possible.
 *
 * @author James Sexton
 * @author Joshua O'Madadhain
 * @param <N> Node parameter type
 * @since 20.0
 */
@Beta
public interface MutableGraph<N> extends Graph<N> {

  /**
   * Adds {@code node} to this graph if it is not already present.
   *
   * <p><b>Nodes must be unique</b>, just as {@code Map} keys must be; they must also be non-null.
   *
   * @return {@code true} iff the graph was modified as a result of this call
   */
  @CanIgnoreReturnValue
  boolean addNode(N node);

  /**
   * Adds an (implicit) edge connecting {@code nodeA} to {@code nodeB} to this graph, if such an
   * edge is not already present.
   *
   * <p>Behavior if {@code nodeA} and {@code nodeB} are not already elements of the graph is
   * unspecified. Suggested behaviors include (a) silently adding {@code nodeA} and {@code nodeB}
   * to the graph (this is the behavior of the default graph implementations) or (b) throwing
   * {@code IllegalArgumentException}.
   *
   * @return {@code true} iff the graph was modified as a result of this call
   * @throws IllegalArgumentException if the introduction of the edge would violate
   *     {@link #allowsSelfLoops()}
   */
  @CanIgnoreReturnValue
  boolean putEdge(N nodeA, N nodeB);

  /**
   * Removes {@code node} from this graph, if it is present.
   * All edges incident to {@code node} in this graph will also be removed.
   *
   * @return {@code true} iff the graph was modified as a result of this call
   */
  @CanIgnoreReturnValue
  boolean removeNode(Object node);

  /**
   * Removes the edge connecting {@code nodeA} to {@code nodeB} from this graph, if it is present.
   *
   * <p>In general, the input nodes are unaffected (although implementations may choose
   * to disallow certain configurations, e.g., isolated nodes).
   *
   * @return {@code true} iff the graph was modified as a result of this call
   */
  @CanIgnoreReturnValue
  boolean removeEdge(Object nodeA, Object nodeB);
}
