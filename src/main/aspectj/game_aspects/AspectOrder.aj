package game_aspects;

/*
 * Author: James Stevens
 * Date: 01 July 2025
 * Course: SWEN 656 - Advanced Software Design and Implementation
 * 
 * Copyright (c) 2025 James Stevens
 * This file is part of the TicTacToe project and may not be used, copied,
 * modified, or distributed without permission.
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
