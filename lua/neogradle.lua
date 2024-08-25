local M = {}

local window_manager = require("windows.task_window")

local config = {}

M.config = config

M.job_id = 0

M.rpcrequest = function(request, ...)
    for _, v in ipairs(arg) do
        request = request .. "', '" .. v
    end
    vim.cmd("echo rpcrequest(" .. M.job_id .. ", '" .. request .. "')")
end

M.setup = function(args)
    local exec_path = "/Users/walhay/projects/NeoGradle/build/install/NeoGradle/bin/neogradle"
    M.job_id = vim.fn.jobstart({ "sh", exec_path }, { rpc = true })

    vim.api.nvim_create_user_command("NeoGradleJobId", function() print(M.job_id) end, {})
    vim.api.nvim_create_user_command("NeoGradleStatus", function() M.rpcrequest("gradle", "status") end, {})
    window_manager.config();
end

return M
