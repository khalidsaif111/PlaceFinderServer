package com.placefinderserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.placefinderserver.model.Goal;
import com.placefinderserver.service.GoalService;

@Controller
@SessionAttributes("goal")
public class GoalController {

	@Autowired
	private GoalService goalService;
	
	public GoalService getGoalService() {
		return goalService;
	}

	public void setGoalService(GoalService goalService) {
		this.goalService = goalService;
	}

	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);
		
		return "addGoal";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') and hasPermission(#goal, 'createGoal')")
	@RequestMapping(value = "addGoal", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {
		
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("Goal set: " + goal.getMinutes());
		
		if(result.hasErrors()) {
			return "addGoal";
		}
		
		getGoalService().addGoal(goal);
		
		return "redirect:index.jsp";
	}
	
}
