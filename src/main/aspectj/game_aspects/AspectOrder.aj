package game_aspects;

/*
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
 */

/**
 * Aspect: AspectOrder
 *
 * Establishes execution precedence for aspects that share join points.
 *
 * This aspect ensures the following order of execution after each move:
 * - {@code RefereeAspect} runs first to evaluate game-ending conditions
 * - {@code TurnAspect} runs second to switch player turns
 *
 * This guarantees that win/draw checks are performed before the active player changes,
 * maintaining logical game flow and correct outcome announcements.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public aspect AspectOrder {

	/**
	 * Declares the execution order for aspects that target the same join point.
	 * Ensures that {@code RefereeAspect} executes before {@code TurnAspect}.
	 */
    declare precedence: RefereeAspect, TurnAspect;
}
