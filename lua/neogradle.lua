local neogradle = {}

local config = {}

neogradle.config = config

neogradle.setup = function(args)
    local exec_path =
    "/Users/walhay/.local/share/lunarvim/site/pack/lazy/opt/neogradle/build/install/NeoGradle/bin/NeoGradle"
    local job_id = vim.fn.jobstart({ "sh", exec_path }, { rpc = true })

    vim.api.nvim_create_user_command("Nigger", function() print(job_id) end, {})
    vim.api.nvim_create_user_command("Zigger", function() vim.rpcrequest(job_id, "neogradle", "nigga") end, {})
end

return neogradle
